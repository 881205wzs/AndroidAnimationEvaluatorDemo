/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2020.05 Davis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.davis.animation.evalutor;


import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;

public class AnimEvaluator {

    public static ValueAnimator build(EvaluatorType type, float duration, ValueAnimator animator) {
        return AnimEvaluator.build(type, duration, animator, (BaseEvaluatorMethod.OnEvaluatorListener[]) null);
    }

    public static ValueAnimator build(EvaluatorType type, float duration, ValueAnimator animator, BaseEvaluatorMethod.OnEvaluatorListener... listeners) {
        BaseEvaluatorMethod t = type.getMethod(duration);

        if (listeners != null)
            t.addEvaluatorListeners(listeners);

        animator.setEvaluator(t);
        return animator;
    }

    public static PropertyValuesHolder build(EvaluatorType type, float duration, PropertyValuesHolder propertyValuesHolder) {
        propertyValuesHolder.setEvaluator(type.getMethod(duration));
        return propertyValuesHolder;
    }


}
